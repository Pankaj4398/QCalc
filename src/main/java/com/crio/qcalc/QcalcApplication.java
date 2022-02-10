package com.crio.qcalc;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QcalcApplication {

	public static void main(String[] args) {
		//SpringApplication.run(QcalcApplication.class, args);
		System.out.println("Hello world!");
		System.out.println("PK stands for Pankaj Kumar");
		StandardCalculator calc = new StandardCalculator();
		calc.add(1, 2);
		System.out.println(calc.getResult());
		// calc.add(Double.MAX_VALUE, 1.0);
		// calc.printResult();
		// calc.add(Double.MAX_VALUE, 2.0);
		// calc.printResult();
		// calc.add(Double.MAX_VALUE, Double.MAX_VALUE);
		// calc.printResult();
		calc.divide(Double.MAX_VALUE, Double.MAX_VALUE);
		calc.printResult();
		calc.divide(Double.MAX_VALUE, 0);
		calc.printResult();

		LogicCalculator calc2 = new LogicCalculator();
		calc2.OR(8, 6);
		calc2.printResult();

	}

}
