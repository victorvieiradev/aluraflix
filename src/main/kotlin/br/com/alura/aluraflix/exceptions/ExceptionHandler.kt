package br.com.alura.aluraflix.exceptions

import br.com.alura.aluraflix.dto.ErrorView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentNotValidExceptionHandler(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorView{
        val mensagensDeErros = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach {
            e ->
            mensagensDeErros.put(e.field, e.defaultMessage)
        }
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            erro = HttpStatus.BAD_REQUEST.name,
            mensagem = mensagensDeErros.toString(),
            path = request.servletPath

        )
    }
}