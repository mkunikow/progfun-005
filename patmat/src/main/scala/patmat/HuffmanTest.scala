package patmat
import Huffman._

/**
 * Created by michal on 10/13/14.
 */
object Main extends App{
//  val sampleTree = makeCodeTree(makeCodeTree(Leaf('x', 1), Leaf('e', 1)),Leaf('t', 2))
//  println(sampleTree);
//
//  println(times("aabbcz".toList))

//  println("aabbz".groupBy(c => c).map(e => (e._1, e._2.length)).toList)

//  val freqs = List(('x',1), ('e', 1), ('t', 2))
//
//  val result = freqs.foldLeft(List[Leaf]()) ((list, freq) => Leaf(freq._1, freq._2) :: list).sortBy(leaf => leaf.weight)
//
//  println(result)

//  println(combine(List(Leaf('x', 1),Leaf('e', 2), Leaf('a', 4), Leaf('f', 5))))
//  println(until(singleton, combine)(List(Leaf('a', 1),Leaf('b', 2), Leaf('c', 3), Leaf('d', 4))))

//  println(createCodeTree("aabbc".toList))
  println(decodedSecret)

  val tree = Fork(Leaf('A',8), Fork(Fork(Leaf('B', 3), Fork(Leaf('C', 1), Leaf('D', 1),List('C', 'D'), 2), List('B', 'C', 'D'), 5), Fork(Fork(Leaf('E', 1), Leaf('F', '1'), List('E', 'F'), 2), Fork(Leaf('G', 1), Leaf('H', 1), List('G', 'H'), 2), List('E', 'F', 'G', 'H'), 4), List('B', 'C', 'D', 'F', 'G', 'H'), 9),   List('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'), 17)
println(decode(tree, List(1,0,0,0,1,0,1,0)))
//  println(decode(tree, List(1,0,0,1)))
//  println(decode(tree, List(1,0,0,0,1,0,1,0)))
  println(encode(tree)("BAC".toList))
  println(convert(tree))
  println(quickEncode(tree)("BAC".toList))

}
