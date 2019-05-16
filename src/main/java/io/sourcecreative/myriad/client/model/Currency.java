package io.sourcecreative.myriad.client.model;

public enum Currency {
	USD {
		@Override
		public int getPrecision() {
			return 2;
		}
	}, 
	RMB {
		@Override
		public int getPrecision() {
			return 2;
		}
	};
		
	public abstract int getPrecision();
	
}
