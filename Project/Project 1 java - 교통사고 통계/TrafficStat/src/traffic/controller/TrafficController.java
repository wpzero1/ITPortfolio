package traffic.controller;


import traffic.domain.TrafficDTO;
import traffic.model.TrafficModel;
import traffic.view.TrafficEndView;

public class TrafficController {

		public static void all() {
			TrafficEndView.AllDatasView(TrafficModel.getAllDatas());
		}
		public static void accidentInsert(TrafficDTO a) {
			TrafficModel.AccidentInsert(a);
			TrafficEndView.AllDatasView(TrafficModel.getAllDatas());
		}
		public static void areaDelete(String City) {
			TrafficEndView.AllDatasView(TrafficModel.AreaDelete(City));
		}
		
		public static void areaSearch(String City) {
			TrafficEndView.AccidentView(TrafficModel.AreaSearch(City));
		}
		public static void areaChange(int date, String City) {
			TrafficModel.AreaChange(date, City);
			TrafficEndView.AllDatasView(TrafficModel.getAllDatas());
		}
		public static void findMax(String category) {
			TrafficEndView.AreaView(TrafficModel.FindMax(category));
		}
}
