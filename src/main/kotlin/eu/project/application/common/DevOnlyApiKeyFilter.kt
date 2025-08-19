package eu.project.application.common

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class DevOnlyApiKeyFilter: OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {

        val passedKey = request.getHeader("x-api-key")
        val devOnlyKey = System.getenv("SIAAPI_DEV_ONLY_KEY")

        when(passedKey == devOnlyKey) {
            true -> { filterChain.doFilter(request, response) }
            false -> {

                response.status = SC_UNAUTHORIZED
                response.writer.write("Unauthorized request")
            }
        }
    }
}