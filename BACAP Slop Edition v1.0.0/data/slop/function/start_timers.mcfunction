scoreboard objectives add slop_sniffer_killed dummy
scoreboard objectives add slop_pink_sheep_killed dummy
scoreboard objectives add slop_consume_water_bottle dummy

# Timers
function bacaped:1sec_timer
function bacaped:10sec_timer

# Install
execute if score bac_created bac_created matches 1 unless score slop slop_install matches 1 run function slop:install
execute if score bac_created bac_created matches 1 run schedule clear slop:bacap_is_not_installed_msg