import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Scanner entry = new Scanner(System.in);

		// Variables
		int num = 0;
		System.out.println("Amount of money: ");
		num = entry.nextInt();

		makeChange(num);

	}// Main

	public static void makeChange(int num) {

		// Variables
		int quarter = 0, dime = 0, nickel = 0, pennie = 0, quarterCount = 0, dimeCount = 0, nickelCount = 0, rest = 0,
				nickelCombination = 0, dimeCombination = 0, quarterCombination = 0;

		List<Integer> list = new ArrayList<Integer>();
		Set<List<Integer>> change = new LinkedHashSet<List<Integer>>();

		// Pennie - always 1 combination
		pennie += num / 1;

		list.add(quarterCount);
		list.add(dimeCount);
		list.add(nickelCount);
		list.add(pennie);

		change.add(list);

		// Nickel - number of combinations = num / 5
		nickelCombination = num / 5;

		for (nickelCount = 1; nickelCount <= nickelCombination; nickelCount++) {

			List<Integer> listNickel = new ArrayList<Integer>();

			rest = num;
			nickel = 0;
			nickel += 5 * nickelCount;
			rest -= nickel;
			pennie = 0;
			pennie += rest / 1;

			listNickel.add(quarterCount);
			listNickel.add(dimeCount);
			listNickel.add(nickelCount);
			listNickel.add(pennie);

			change.add(listNickel);

		} // end Nickel

		// Dime - number of combinations = num / 10
		dimeCombination = num / 10;

		for (dimeCount = 1; dimeCount <= dimeCombination; dimeCount++) {

			List<Integer> listDime = new ArrayList<Integer>();

			rest = num;
			dime = 0;
			dime += 10 * dimeCount;
			rest -= dime;

			nickelCombination = rest / 5;

			if (nickelCombination > 0) {
				for (nickelCount = 1; nickelCount <= nickelCombination; nickelCount++) {

					List<Integer> listNickel = new ArrayList<Integer>();

					nickel = 0;
					nickel += 5 * nickelCount;
					rest -= nickel;
					pennie = 0;
					pennie += rest / 1;

					listNickel.add(quarterCount);
					listNickel.add(dimeCount);
					listNickel.add(nickelCount);
					listNickel.add(pennie);

					change.add(listNickel);

					rest += nickel;

				}
			}

			nickelCount = 0;
			pennie = 0;
			pennie += rest / 1;

			listDime.add(quarterCount);
			listDime.add(dimeCount);
			listDime.add(nickelCount);
			listDime.add(pennie);

			change.add(listDime);

		} // Dime end for

		// Quarter - number of combinations = num / 25
		quarterCombination = num / 25;

		for (quarterCount = 1; quarterCount <= quarterCombination; quarterCount++) {

			List<Integer> listQuarter = new ArrayList<Integer>();

			rest = num;
			quarter = 0;
			quarter += 25 * quarterCount;
			rest -= quarter;
			
			dimeCombination = rest / 10;
			if (dimeCombination > 0) {
				for (dimeCount = 1; dimeCount <= dimeCombination; dimeCount++) {

					List<Integer> listDime = new ArrayList<Integer>();

					dime = 0;
					dime += 10 * dimeCount;
					rest -= dime;
					
					nickelCombination = rest / 5;
					
					if (nickelCombination > 0) {
						for (nickelCount = 1; nickelCount <= nickelCombination; nickelCount++) {

							List<Integer> listNickel = new ArrayList<Integer>();
							
							nickel = 0;
							nickel += 5 * nickelCount;
							rest -= nickel;
							pennie = 0;
							pennie += rest / 1;
							
							listNickel.add(quarterCount);
							listNickel.add(dimeCount);
							listNickel.add(nickelCount);
							listNickel.add(pennie);

							change.add(listNickel);

							rest += nickel;
							
						}
						
					}				
					
					nickelCount = 0;
					pennie = 0;
					pennie += rest / 1;

					listDime.add(quarterCount);
					listDime.add(dimeCount);
					listDime.add(nickelCount);
					listDime.add(pennie);

					change.add(listDime);

				}
			} // end dimeComb if

			rest = num;
			rest -= quarter;
			
			nickelCombination = rest / 5;
			if (nickelCombination > 0) {
				for (nickelCount = 1; nickelCount <= nickelCombination; nickelCount++) {

					List<Integer> listNickel = new ArrayList<Integer>();

					dimeCount = 0;
					
					nickel = 0;
					nickel += 5 * nickelCount;
					rest -= nickel;
					pennie = 0;
					pennie += rest / 1;
					
					listNickel.add(quarterCount);
					listNickel.add(dimeCount);
					listNickel.add(nickelCount);
					listNickel.add(pennie);

					change.add(listNickel);

					rest += nickel;
				}
			} // end nickel if
			
			rest = num;
			rest -= quarter;
		
			nickelCount = 0;
			dimeCount = 0;
			pennie = 0;
			pennie += rest / 1;

			listQuarter.add(quarterCount);
			listQuarter.add(dimeCount);
			listQuarter.add(nickelCount);
			listQuarter.add(pennie);

			change.add(listQuarter);

		} // end quarter for

		System.out.println(change);
		System.out.println(change.size());
	}// makeChange
}
