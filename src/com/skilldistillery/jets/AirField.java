package com.skilldistillery.jets;

public class AirField {
	
	Jet[] jets = new Jet[15];
	
	public AirField() {
			jets[0] = new FighterJet("F35   ", 1_200, 1_200, 94_600_000);
			jets[1] = new FighterJet("J-20  ", 1_305, 1_100, 50_000_000);
			jets[2] = new FighterJet("MiG-29", 1_491, 889, 22_000_000);
			jets[3] = new FighterJet("Su-34 ", 1_367, 2_485, 36_000_000);
			jets[4] = new FighterJet("F-22  ", 1_498, 1_839, 339_000_000);
			jets[5] = new CargoPlane("An-178", 497.7, 3_417, 70_000_000);
			jets[6] = new CargoPlane("C-2   ", 553, 7_580, 136_000_000);
			jets[7] = new CargoPlane("KC-46 ", 529, 7_350, 147_700_000);
			jets[8] = new JetImpl("A380  ", 634, 944, 375_300_000);
			jets[9] = new JetImpl("737   ", 583, 3_000, 87_000_000);
	}
	
	

	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}
	
}
