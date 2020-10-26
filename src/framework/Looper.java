package framework;

class Looper {
    public void prepare() {
        PlayerGenerator generator = new PlayerGenerator();
        PlayerManagerService.getInstance().addPlayers(generator.generate());
    }

    public void loop() {

    }
}
