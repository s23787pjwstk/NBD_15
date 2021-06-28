db.people.mapReduce(
    function() {
	if (this.nationality == "Poland" && this.sex == "Female") {
		this.credit.forEach(e => {
			emit(e.currency, {
				count: 1,
				total: +e.balance
			});
        })}},
        function(key, values) {
            reducedVal = {count: 0, total: 0};
        
            values.forEach(e => {
                reducedVal.count += e.count;
                reducedVal.total += e.total;
            });
        
            return reducedVal;
        },{
            out: "feMon",
            function(key, reducedVal) {
                return {
                    avgBal: reducedVal.total / reducedVal.count,
                    sumBal: reducedVal.total
                };
            }
        }
)

printjson(db.feMon.find().toArray());