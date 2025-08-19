package eu.project.application.export.service

import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import eu.project.application.export.model.Word
import java.io.ByteArrayOutputStream
import org.springframework.stereotype.Service

@Service
class CsvServiceImpl: CsvService {

    private val csvGenerator = csvWriter()

    override fun prepareFileToExportWords(wordsToExport: List<Word>): ByteArray {

        val rows = mutableListOf(listOf("Term", "Definition"))
        rows += wordsToExport.map { listOf(it.value, "") }

        val outputStream = ByteArrayOutputStream()
        csvGenerator.writeAll(rows = rows, ops = outputStream)

        return outputStream.toByteArray()
    }
}