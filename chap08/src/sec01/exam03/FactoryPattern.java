package sec01.exam03;

public class FactoryPattern {

	public static void main(String[] args) {

		FigureFactory figureFactory = new FigureFactory();
		
		Figure fig1 = figureFactory.getFigure("CIRCLE");
		
		fig1.draw();
		
		Figure fig2 = figureFactory.getFigure("RECTANGLE");
		
		fig2.draw();
		
		Figure fig3 = figureFactory.getFigure("SQUARE");
		
		fig3.draw();

	}

}
