import kotlin.test.Test
import kotlin.test.assertEquals

internal class TreeBuilderTest {

    @Test
    fun test() {
        val t = node(1) {
            left = node(21)
            right = node(22) {
                right = node(222)
            }
        }

        assertEquals(  1, t.value)
        assertEquals( 21, t.left?.value)
        assertEquals( 22, t.right?.value)
        assertEquals( 222, t.right?.right?.value)

    }

    data class Node(val value: Int, var left: Node? = null, var right: Node? = null)

    fun node(value: Int, build: (Node.() -> Unit)? = null): Node {
        val node = Node(value)
        if(build != null) node.apply(build)
        return node
    }
}

