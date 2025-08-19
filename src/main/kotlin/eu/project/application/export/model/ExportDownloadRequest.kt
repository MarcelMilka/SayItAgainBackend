package eu.project.application.export.model

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ExportDownloadRequest(

    @field:Size(min = 1, message = "{export.words.min}")
    @field:Valid val wordsToExport: List<Word>
)

data class Word(

    @field:NotBlank(message = "{export.words.blank}")
    val value: String
)