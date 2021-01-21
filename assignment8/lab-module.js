"use strict";
let module = (()=>{
    function createBicyclePrototye(){
        return {
            speed: 0,
            applyBrake(d) {
                this.speed -= d;
            },
            speedup(d) {
                this.speed += d;
            }
        }
    }

    function createMountainBikeProtoype(prototype){
        return {
            gear: 1,
            setGear(gear) {
                this.gear = gear;
            },
            __proto__: Object.create(prototype)
        };
    }

    function start(){
        let bicyclePrototype = createBicyclePrototye();
        let mountainBikePrototype = createMountainBikeProtoype(bicyclePrototype);

        let bicycle = Object.create(bicyclePrototype);
        let mountainBike = Object.create(mountainBikePrototype);

        console.log(bicycle)

        console.log(bicycle.speed)
        bicycle.speedup(5)
        console.log(bicycle.speed)
        bicycle.speedup(10)
        console.log(bicycle.speed)
        bicycle.applyBrake(8)
        console.log(bicycle.speed)
        bicycle.applyBrake(7)
        console.log(bicycle.speed)
        
        console.log(mountainBike)

        console.log(mountainBike.speed)
        mountainBike.speedup(4)

        console.log(mountainBike.gear)
        mountainBike.setGear(3)
        console.log(mountainBike.gear)

        console.log(mountainBike.speed)
        mountainBike.speedup(8)
        console.log(mountainBike.speed)
        mountainBike.applyBrake(5)
        console.log(mountainBike.speed)
        mountainBike.applyBrake(7)
        console.log(mountainBike.speed)
    };
    return {start}
})();

module.start()