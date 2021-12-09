import kotlin.test.Test
import kotlin.test.assertEquals

internal class TreeBuilderTest {

    @Test
    fun test() {
        val t = Tree {
            node(1) {
                left = node(21)
                right = node(22) {
                    right = node(222)
                }
            }
        }

        assertEquals(  1, t.root?.value)
        assertEquals( 21, t.root?.left?.value)
        assertEquals( 22, t.root?.right?.value)
        assertEquals( 222, t.root?.right?.right?.value)

    }

    data class Tree(var root: Node? = null) {
        companion object {
            operator fun invoke(buildFun: Tree.() -> Unit): Tree = Tree().apply(buildFun)
        }

        fun node(value: Int, buildFun: (Node.() -> Unit)?): Node {
            val r = Node(value)
            if(buildFun != null) r.apply(buildFun)
            root = r
            return r
        }
    }


    data class Node(val value: Int, var left: Node? = null, var right: Node? = null) {
        fun node(value: Int, buildFun: (Node.() -> Unit)? = null): Node {
            val node = Node(value)
            if (buildFun != null) node.apply(buildFun)
            return node
        }
    }
}

