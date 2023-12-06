import kotlinx.html.HTML
import kotlinx.html.TABLE
import kotlinx.html.TagConsumer
import kotlinx.html.TR
import kotlinx.html.TH
import kotlinx.html.TD
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import kotlinx.html.js.table
import org.w3c.dom.HTMLElement
import org.w3c.dom.Node
import org.w3c.dom.asList
import org.w3c.dom.parsing.DOMParser
import org.w3c.dom.raw.HTMLTableElement
import org.w3c.dom.raw.HTMLTableRowElement
import org.w3c.dom.raw.HTMLTableSectionElement
import org.w3c.dom.url.URL
import org.w3c.files.FileReader
import org.w3c.files.get
import kotlin.browser.document
import kotlin.browser.window

data class Producto(val nombre: String, val cantidad: Int, val precio: Double)

fun main() {
    // Cargar datos del archivo
    window.fetch("datos.json")
        .then { it.text() }
        .then { jsonString ->
            // Convertir el archivo JSON en un objeto JavaScript
            val datos = JSON.parse<Array<Producto>>(jsonString)

            // Agregar los productos a la tabla
            agregarProductosATabla(datos)
        }
}

fun agregarProductosATabla(productos: Array<Producto>) {
    val tabla = document.getElementsByTagName("table")[0] as HTMLTableElement
    val tbody = tabla