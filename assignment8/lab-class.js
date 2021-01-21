let classModule = (()=>{
    "use strict";

    class Bicycle {
        speed = 0;
        applyBrake(d) {
            this.speed -= d;
        }
        speedup(d) {
            this.speed += d;
        }
    }

    class mountainBike extends Bicycle{
        gear = 1;
        setGear(g) {
            this.gear = g;
        }
    }

    function start(){
        let bicycle = new Bicycle;
        let mountainBike = new mountainBike;

        console.log("Code with class")

        console.log(bicycle.speed)
        console.log(bicycle.speedup(5))
        console.log(bicycle.speed)
        console.log(bicycle.speedup(10))
        console.log(bicycle.speed)
        console.log(bicycle.applyBrake(8))
        console.log(bicycle.speed)
        console.log(bicycle.applyBrake(7))
        console.log(bicycle.speed)
        

        console.log(mountainBike.speed)
        console.log(mountainBike.speedup(4))

        console.log(mountainBike.gear)
        console.log(mountainBike.setGear(3))
        console.log(mountainBike.gear)

        console.log(mountainBike.speed)
        console.log(mountainBike.speedup(8))
        console.log(mountainBike.speed)
        console.log(mountainBike.applyBrake(5))
        console.log(mountainBike.speed)
        console.log(mountainBike.applyBrake(7))
        console.log(mountainBike.speed)
    };
    return {start}
})();

module.start()