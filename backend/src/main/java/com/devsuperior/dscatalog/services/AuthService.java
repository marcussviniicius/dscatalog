package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.EmailDTO;
import com.devsuperior.dscatalog.entities.PasswordRecover;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.PasswordRecoverRepository;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${email.password-recover.token.minutes}")
    private Long tokenMinutes;

    @Value("${email.password-recover.uri}")
    private String recoverUri;

    private final UserRepository userRepository;

    private final PasswordRecoverRepository passwordRecoverRepositoryRepository;

    private final EmailService emailService;

    @Transactional
    public void createRecoveryToken(EmailDTO body) {

        User user = userRepository.findByEmail(body.getEmail());
        if (user == null){
            throw new ResourceNotFoundException("Email não encontrado");
        }

        String token = UUID.randomUUID().toString();

        PasswordRecover entity = new PasswordRecover();
        entity.setEmail(body.getEmail());
        entity.setToken(token);
        entity.setExpiration(Instant.now().plusSeconds(tokenMinutes * 60L));
        entity = passwordRecoverRepositoryRepository.save(entity);

        String text =
                "Recebemos uma solicitação para redefinição de senha da sua conta.\n\n"
                        + "Para cadastrar uma nova senha, acesse o link abaixo:\n\n"
                        + recoverUri + token + "\n\n"
                        + "Este link é válido por " + tokenMinutes + " minutos.\n\n"
                        + "Caso você não tenha solicitado a redefinição, desconsidere este e-mail.\n\n"
                        + "Atenciosamente,\n"
                        + "Equipe de Suporte";

        emailService.sendEmail(body.getEmail(), "Recuperação de Senha", text);
    }
}
