# Seamless Cursor

**Never lose your mouse position in menus again.**

Smooth, persistent mouse cursor positioning for Minecraft menus, container updates, and server chest GUIs.

[![Modrinth](https://img.shields.io/badge/Modrinth-Available-00AF5C?style=flat-square&logo=modrinth)](https://modrinth.com/mod/seamless-cursor)
![ModLoader Fabric](https://img.shields.io/badge/ModLoader-Fabric-lightgrey?style=flat-square)
![Client-Side Only](https://img.shields.io/badge/Side-Client--Only-brightgreen?style=flat-square)
![Ban Risk 0%](https://img.shields.io/badge/Ban%20Risk-0%25%20(Pure%20QoL)-brightgreen?style=flat-square)
![License MIT](https://img.shields.io/badge/License-MIT-orange?style=flat-square)

---

## 🎯 What is Seamless Cursor?

When playing on servers like **Hypixel** (SkyBlock, Bedwars, SkyWars) or using server menus, clicking through chest GUIs is often frustrating:
1. Every time a menu changes pages, updates items, or transitions to a sub-menu, vanilla Minecraft **snaps your mouse cursor back to the exact center of the screen**.
2. Worse, during the brief transition packet, your camera can jerk and your mouse hitches.

**Seamless Cursor fixes this completely.**

Your mouse stays **exactly where you left it** — right on the slot or button you were interacting with. Transitions feel completely instant, smooth, and natural, as if nothing closed at all.

---

## ✨ Features

- **No Center Snapping:** Your mouse cursor never resets to `(width / 2, height / 2)` during menu transitions or reopening.
- **Zero Mouse Hitching:** Eliminates the brief cursor stutter and background camera jitter when server plugins send `ContainerClose` followed by `OpenScreen`.
- **Pure Client-Side:** Requires **NO** server-side mod. Works on any multiplayer server.
- **Safe Bounds Clamping:** Safely clamps coordinates within window limits if window dimensions change.
- **Ultra Lightweight:** Zero external mod dependencies (doesn't even require Fabric API). Under 45 KB jar footprint!
- **Zero-Config:** Plug-and-play. Drop it into your mods folder and it works immediately.

---

## 🛡️ Is it Safe? (Anticheat & Server Rules)

> [!NOTE]
> **100% Ban Safe.**

- **Zero Network Packets:** Minecraft network protocol does **not** send mouse cursor X/Y coordinates to servers. Servers only receive slot click events when you manually click.
- **No Automation / No Macros:** Seamless Cursor **does not click for you**. All clicks are 100% manual.
- **Client-Side Cosmetic QoL:** Complies fully with Hypixel's *"Allowed Modifications - Aesthetic & GUI Improvements"* guidelines (similar to built-in cursor memory features in Badlion Client and Lunar Client).

---

## 🚀 Installation

1. Install **Fabric Loader**.
2. Download `seamless-cursor-1.0.0.jar` from [Modrinth](https://modrinth.com/mod/seamless-cursor) or [GitHub Releases](https://github.com/MehmetCanWT/seamless-cursor/releases).
3. Place the `.jar` into your `.minecraft/mods` folder.
4. Launch Minecraft and enjoy smooth menus!

---

## 📄 Links & License

- **GitHub Repository:** [MehmetCanWT/seamless-cursor](https://github.com/MehmetCanWT/seamless-cursor)
- **Issue Tracker:** [GitHub Issues](https://github.com/MehmetCanWT/seamless-cursor/issues)
- **License:** [MIT License](https://github.com/MehmetCanWT/seamless-cursor/blob/main/LICENSE)
