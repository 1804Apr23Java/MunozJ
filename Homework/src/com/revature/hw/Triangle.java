package com.revature.hw;

public class Triangle {
	
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne()==this.getSideTwo() && this.getSideTwo()==this.getSideThree()) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne()==this.getSideTwo() ||
					this.getSideTwo()==this.getSideThree()||
					this.getSideOne()==this.getSideThree()) {
				return true;
			}
			
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne()!=this.getSideTwo() &&
					this.getSideTwo()!=this.getSideThree()&&
					this.getSideOne()!=this.getSideThree()) {
				return true;
			}
			return false;
		}

}
