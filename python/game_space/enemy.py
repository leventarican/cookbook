import pygame
from pygame.sprite import Sprite

class Enemy(Sprite):
    def __init__(self, game_space):
        super().__init__()
        self.screen = game_space.screen
        self.settings = game_space.settings

        self.image = pygame.image.load('enemy.png')
        self.rect = self.image.get_rect()
        self.rect.x = self.rect.width
        self.rect.y = self.rect.height
        self.x = float(self.rect.x)

    def update(self):
        self.x += (self.settings.enemy_speed * self.settings.enemy_direction)
        self.rect.x = self.x

    def check_edges(self):
        screen_rect = self.screen.get_rect()
        if self.rect.right >= screen_rect.right or self.rect.left <= 0:
            return True