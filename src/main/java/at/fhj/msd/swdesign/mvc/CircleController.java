package at.fhj.msd.swdesign.mvc;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CircleController {
	
	private CircleModel model;
	private CircleView view;
	
	public CircleController(){
		
		model = new CircleModel();
		view = new CircleView();
	
		// listener 
		view.setCalcListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long radius = Long.valueOf(view.getRadius());


				model.setRadius(radius);

				view.setResult(model.getCircleCalc());



			}
		});
	}

	public void showView() {
		view.setVisible(true);
	}

}
