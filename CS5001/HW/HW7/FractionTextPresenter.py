class FractionTextPresenter:
    def __init__(self, fraction):
        self.fraction = fraction

    def draw(self):
        print(self.fraction, end=' ')

    def update_model(self, fraction):
        self.fraction = fraction
        self.update()

    def update(self):
        self.draw()

