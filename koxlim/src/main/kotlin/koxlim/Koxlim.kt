package koxlim

import org.w3c.dom.Document
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory

class Koxlim(stream: InputStream) {
    constructor(xml: String) : this(xml.byteInputStream())

    val document: Document

    init {
        val documentFactory = DocumentBuilderFactory.newInstance().apply {
            isIgnoringComments = false
        }
        document = documentFactory.newDocumentBuilder().parse(stream)
        document.documentElement.normalize()
    }
}
