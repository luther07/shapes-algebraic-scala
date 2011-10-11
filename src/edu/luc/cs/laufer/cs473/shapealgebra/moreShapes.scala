package edu.luc.cs.laufer.cs473.shapealgebra

import java.awt.Color

/*
 * Some additional shape classes added later.
 */

case class Stroke(c: Color, shape: Shape) extends Decorator(shape)

case class Fill(shape: Shape) extends Decorator(shape)

case class Outline(shape: Shape) extends Decorator(shape)

case class Point(x: Int, y: Int)

case class Polygon(points: Point*) extends Shape

case class Rotate(deg: Int, shape: Shape) extends Decorator(shape)

case class Circle(r: Int) extends Shape

// TODO: your job (avoid inheritance among case classes)
