package streams
import Bloxorz._

object StringParserTerrainImpl extends StringParserTerrain {
  val level = ""
}

import StringParserTerrainImpl.Pos

/**
 * Created by michal on 11/3/14.
 */
object Main extends App  {


  val f = StringParserTerrainImpl.terrainFunction(Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o')))
  println(f(Pos(1,0)))
  println(StringParserTerrainImpl.findChar('Y',Vector(
                                                      Vector('o', 'o', 'o', 'o'),
                                                      Vector('o', 'o', 'o', 'o'),
                                                      Vector('o', 'Y', 'o', 'o'),
                                                      Vector('o', 'o', 'o', 'o') )))

}
