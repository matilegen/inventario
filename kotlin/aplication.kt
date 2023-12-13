val users=mutableMapOf<String, String>()
routing{
    post("/login"){
        val email=call.parameters["email"] ?: return@post call.respond(HttpStatusCode.BadRequest, "Correo Electronico requerido")
        val password = call.parameters["password"] ?:return@post call.respond(HttpStatusCode.BadRequest, "Contraseña requerida")

        if(users[email] = password){
            call.respond(HttpStatusCode.ok, "Inicio de sesion exitoso")
        }else{
            call.respond
        }
    }
}