db.people.mapReduce(
    function(){emit(this.sex,{count: 1, totHeight: +this.height, totWeight: +this.weight});},
    function(key, values){
    reducedVal = {
            count: 0,
            totHeight: 0,
            totWeight: 0
        };
    values.forEach(e => {
        reducedVal.count += e.count,
        reducedVal.totHeight += e.totHeight,
        reducedVal.totWeight += e.totWeight
        });

    return reducedVal;
    },
    {
        out: "wagWzrost",
        finalize: function(key, reducedVal){
            return {
                avgHeight: reducedVal.totHeight / reducedVal.count,
                avgWeight: reducedVal.totWeight / reducedVal.count
            }
        }
    }
)
db.wagWzrost.find({})