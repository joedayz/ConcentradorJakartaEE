package pe.farmaciasperuanas.concentrador.controller;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

import pe.farmaciasperuanas.concentrador.util.Constantes;

@ApplicationPath("/")
@ApplicationScoped
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({Constantes.ROL_ADMIN, Constantes.ROL_PUBLIC})
public class ConcentradorRestApplication extends Application {
}
