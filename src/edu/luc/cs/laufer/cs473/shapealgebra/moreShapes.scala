package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Color

/*
 * Some additional shape classes added later.
 */

case class Stroke(c: Color, s: Shape) extends Decorator

case class Fill(s: Shape) extends Decorator

case class Outline(s: Shape) extends Decorator

case class Point(x: Int, y: Int) extends Shape

case class Polygon(ps: Point*) extends Shape

case class Rotate(deg: Int, s: Shape) extends Decorator

case class Circle(r: Int) extends Shape

// TODO: your job (avoid inheritance among case classes)
