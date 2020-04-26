function tick() {
        console.log('tick');
}
function startTicks() {
    while (true) {
        setTimeout(tick, 1000);
    }
}