fn main() -> Result<(), battery::Error> {
    let manager = battery::Manager::new()?;

    for (idx, maybe_battery) in manager.batteries()?.enumerate() {
        let battery = maybe_battery?;
        println!("Battery #{}:", idx);
        println!("State: {:?}", battery.state());
        println!("[only if charging] Time to full charge: {:?}", battery.time_to_full());
        println!("[only if not charging] Time to empty: {:?}", battery.time_to_empty());
        println!("Energy Rate: {:?}", battery.energy_rate());
        println!("Cycle count: {:?}", battery.cycle_count());
        println!("");

    }

    Ok(())
}