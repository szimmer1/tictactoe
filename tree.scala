package tree

class Tree[T](root: Node[T]) {
  var root = root
}

class Node[T](data: T) {
  var data: T = data
  var children: List[Node] = List()

  override def toString(): String = data.toString()
}
