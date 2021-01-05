function solution(bridge_length, weight, truck_weights) {
    const bridge = new Bridge(bridge_length, weight);

    let day = 1;
    bridge.push(truck_weights.shift());

    while (!bridge.isEmpty() || truck_weights.length !== 0) {
        bridge.cross();

        if (truck_weights.length !== 0) {
            const truck = truck_weights.shift();

            if (bridge.isPushPossible(truck)) {
                bridge.push(truck);
            } else {
                truck_weights.unshift(truck);
            }
        }

        day += 1;
    }

    return day;
}

class Bridge {
    constructor(length, weight) {
        this.weight = weight;
        this.crossing = [];

        for (let len = 1; len <= length; len += 1) {
            this.crossing.push(0);
        }
    }

    cross() {
        this.crossing[this.crossing.length - 1] = 0;

        for (let index = this.crossing.length - 1; index > 0; index -= 1) {
            this.crossing[index] = this.crossing[index - 1];
        }

        this.crossing[0] = 0;
    }

    isPushPossible(truck) {
        if (this.weight >= truck + this.crossing.reduce((prev, current) => prev + current)) {
            return true;
        } else {
            return false;
        }
    }

    push(truck) {
        this.crossing[0] = truck;
    }

    isEmpty() {
        for (let index = 0; index < this.crossing.length; index += 1) {
            if (this.crossing[index] !== 0) {
                return false;
            }
        }
        return true;
    }
}

console.log(solution(2, 10, [7, 4, 5, 6]));