import sys
import pygame

from settings import Settings
from ship import Ship
from bullet import Bullet
from enemy import Enemy

class Space:
    def __init__(self):
        pygame.init()
        self.settings = Settings()
        self.screen = pygame.display.set_mode((
            self.settings.screen_width,
            self.settings.screen_height
        ))
        pygame.display.set_caption('space')
        self.ship = Ship(self)
        self.bullets = pygame.sprite.Group()
        self.enemies = pygame.sprite.Group()
        self._create_enemies()

    def run(self):
        while True:
            self._check_events()
            self.ship.update()
            self.bullets.update()
            self._update_enemies()
            self._update_screen()

    def _check_events(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    self._fire_bullet()
                if event.key == pygame.K_RIGHT:
                    self.ship.moving_right = True
                if event.key == pygame.K_LEFT:
                    self.ship.moving_left = True
            elif event.type == pygame.KEYUP:
                if event.key == pygame.K_RIGHT:
                    self.ship.moving_right = False
                if event.key == pygame.K_LEFT:
                    self.ship.moving_left = False

    def _update_screen(self):
        self.screen.fill(self.settings.bg_color)
        self.ship.blitme()
        for bullet in self.bullets.sprites():
            bullet.draw_bullet()
        self.enemies.draw(self.screen)
        pygame.display.flip()

    def _fire_bullet(self):
        bullet = Bullet(self)
        self.bullets.add(bullet)

    def _create_enemies(self):
        enemy = Enemy(self)
        self.enemies.add(enemy)

    def _update_enemies(self):
        self.enemies.update()
        self._check_enemy_edges()

    def _check_enemy_edges(self):
        for enemy in self.enemies.sprites():
            if enemy.check_edges():
                self._change_enemy_direction()
                break

    def _change_enemy_direction(self):
        for enemy in self.enemies.sprites():
            enemy.rect.y += self.settings.enemy_drop_speed
        self.settings.enemy_direction *= 1

if __name__ == '__main__':
    space = Space()
    space.run()
