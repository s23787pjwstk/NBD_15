db.people.mapReduce(
	function() {
		var bmi = this.weight / ((this.height / 100) ** 2);
		 var v = {
			count: 1,
			totalBmi: bmi,
			minBmi: bmi,
			maxBmi: bmi
		};
		emit(this.nationality, v);
	},
	function(key, values) {
		reducedVal = {
			count: 0,
			totalBmi: 0,
			minBmi: -1,
			maxBmi: -1
		}
	
		values.forEach(e => {
			reducedVal.count += e.count
			reducedVal.totalBmi += e.totalBmi
	
			if (reducedVal.minBmi == -1 || e.minBmi < reducedVal.minBmi)
			reducedVal.minBmi = reducedVal.minBmi
	
			if (reducedVal.maxBmi == -1 || e.maxBmi > reducedVal.maxBmi)
			reducedVal.maxBmi = e.maxBmi
		})
	
		return reducedVal
	},
	{
		out: "bmi",
		function(key, reducedVal) {
			return {
				avg: reducedVal.totalBmi / reducedVal.count,
				min: reducedVal.minBmi,
				max: reducedVal.maxBmi
			}
		}
	}
)

printjson(db.bmi.find().toArray())