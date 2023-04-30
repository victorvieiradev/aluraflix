package br.com.alura.aluraflix.exceptions

import java.lang.RuntimeException

class NotFoundException(mensagem: String): RuntimeException(mensagem)