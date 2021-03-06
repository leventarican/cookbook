import pygame
from pygame.sprite import Sprite

class Bullet(Sprite):
    def __init__(self, game_space):
        super().__init__()
        self.screen = game_space.screen
        self.settings = game_space.settings
        self.color = self.settings.bullet_color

        self.rect = pygame.Rect(0, 0, self.settings.bullet_width, self.settings.bullet_height)
        self.rect.midtop = game_space.ship.rect.midtop

        self.y = float(self.rect.y)

    def right(self):
        # print('{};{}'.format(self.rect.midtop[0], self.rect.midtop[1]))
        self.rect.midtop = (self.rect.midtop[0] + 100, self.rect.midtop[1])

    def left(self):
        self.rect.midtop = (self.rect.midtop[0] - 100, self.rect.midtop[1])

    def update(self):
        self.y -= self.settings.bullet_speed
        self.rect.y = self.y

    def draw_bullet(self):
        pygame.draw.rect(self.screen, self.color, self.rect)
