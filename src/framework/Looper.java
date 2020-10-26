package framework;

class Looper {
    public void prepare() {
        PlayerGenerator generator = new PlayerGenerator();
        PlayerManagerService.getInstance().addPlayers(generator.generate());
    }

    public void loop() {
        while (!PlayerManagerService.getInstance().isMoreThanOnePlayers()) {
            PlayerManagerService.getInstance().onRound();
            System.out.println("回合结束");
        }
    }
}
