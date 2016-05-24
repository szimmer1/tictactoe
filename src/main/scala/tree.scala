package tree

class Tree[T](root: Node[T]) {
  var _root = root
}

class Node[T](data: T) {
  var _data: T = data
  var children: List[Node[T]] = List[Node[T]]()

  override def toString(): String = _data.toString()
}
