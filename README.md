# Quantum Trusted Platform Module (QTPM) for IoT Security

This repository contains research code, notebooks, and datasets supporting experiments on **quantum-randomness-backed trusted computing for IoT security**.

The work explores how entropy from a physical Quantum Random Number Generator (QRNG) can be incorporated into trusted-computing workflows and evaluated against software-generated randomness.

## Repository contents

### `QRNG/`
Code used for QRNG experiments and data generation. Running this portion requires the Quantis software stack and the Java wrapper for compatible ID Quantique hardware.

### `PRNG/`
Java code used to generate pseudorandom comparison datasets.

### `data_set/`
Random-number datasets used in the experiments.

### `2D_Walk_Test.ipynb`
Notebook implementing a two-dimensional random-walk analysis used to inspect statistical behavior.

### `MSD.ipynb`
Notebook for mean-squared-displacement analysis.

### `QRNG_plotting.ipynb`
Visualization and analysis notebook for QRNG experimental data.

## Research focus

The repository supports investigation of:

- physical QRNG output for trusted-computing use cases
- comparison of QRNG and pseudorandom data
- statistical analysis and visualization of randomness
- integration constraints around physical QRNG hardware
- IoT security and trusted-computing architectures

## Hardware / dependency note

The QRNG portions depend on compatible ID Quantique hardware and vendor libraries. Some vendor-dependent components are intentionally not redistributed in this repository.

## Related publication

This repository supports research associated with:

**“Developing Quantum Trusted Platform Module (QTPM) to Advance IoT Security”**  
*Future Internet*, 2025.

## Author

Oluwole Adetifa  
[LinkedIn](https://www.linkedin.com/in/oluwole-adetifa-278586113) • [Portfolio](https://oluwoleadetifa.com)
