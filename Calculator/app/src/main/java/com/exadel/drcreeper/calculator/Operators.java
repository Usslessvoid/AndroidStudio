package com.exadel.drcreeper.calculator;

public enum Operators
{
	PLUS{

		@Override
		public double calculate(double a, double b)
		{
			return a + b;
		}
	},
	MINUS{

		@Override
		public double calculate(double a, double b)
		{
			// TODO: Implement this method
			return a - b;
			}
	},
	MUL{

		@Override
		public double calculate(double a, double b)
		{
			// TODO: Implement this method
			return a * b;
		}

		
	},
	DIV{

		@Override
		public double calculate(double a, double b)
		{
			// TODO: Implement this method
			return a / b;
		}

	};
	public abstract double calculate(double a,double b);
}
