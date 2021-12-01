# RuAnnoy

[![main](https://github.com/kis3tar/RuAnnoy/actions/workflows/main.yml/badge.svg)](https://github.com/kis3tar/RuAnnoy/actions/workflows/main.yml)
[![Build status](https://img.shields.io/appveyor/ci/kis3tar/RuAnnoy/master.svg)](https://ci.appveyor.com/project/kis3tar/RuAnnoy)
[![Crates.io](https://img.shields.io/crates/v/ru_annoy.svg)](https://crates.io/crates/ru_annoy)
[![Coverage Status](https://coveralls.io/repos/github/kis3tar/RuAnnoy/badge.svg?branch=master)](https://coveralls.io/github/kis3tar/RuAnnoy?branch=master)
[![MIT License](https://img.shields.io/github/license/kis3tar/RuAnnoy.svg)](https://github.com/kis3tar/RuAnnoy/blob/master/LICENSE)
========
<!-- [![Build Status](https://img.shields.io/travis/kis3tar/RuAnnoy/master.svg)](https://travis-ci.org/kis3tar/RuAnnoy) -->

This library is a rust port of https://github.com/spotify/annoy , currently only index serving part is implemented

## Usage
```rust
use ru_annoy::*;

let index = AnnoyIndex::load(10, "index.ann", IndexType::Angular).unwrap();
let v0 = index.get_item_vector(0);
let nearest = index.get_nearest(v0.as_ref(), 5, -1, true);
```

## FFI support
### dotnet nuget packages

| Runtimes                      | Nuget package                                                                                                                                 |
| ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| RuAnnoy                       | [![NuGet version](https://buildstats.info/nuget/RuAnnoy)](https://www.nuget.org/packages/RuAnnoy)                                             |
| RuAnnoy-Batteries-Windows-x64 | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Windows-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Windows-x64) |
| RuAnnoy-Batteries-Linux-x64   | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Linux-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Linux-x64)     |
| RuAnnoy-Batteries-Darwin-x64  | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Darwin-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Darwin-x64)   |

### Installation
```xml
  <ItemGroup>
    <PackageReference Include="RuAnnoy" />
    <PackageReference Include="RuAnnoy-Batteries-Windows-x64" />
  </ItemGroup>
```
