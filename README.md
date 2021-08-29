# RuAnnoy

[![Build Status](https://img.shields.io/travis/kis3tar/RuAnnoy/master.svg)](https://travis-ci.org/kis3tar/RuAnnoy)
[![Build status](https://img.shields.io/appveyor/ci/kis3tar/RuAnnoy/master.svg)](https://ci.appveyor.com/project/kis3tar/RuAnnoy)
![Crates.io](https://img.shields.io/crates/v/ru_annoy.svg)
[![MIT License](https://img.shields.io/github/license/kis3tar/RuAnnoy.svg)](https://github.com/kis3tar/RuAnnoy/blob/master/LICENSE)
========

This library is a rust port of https://github.com/spotify/annoy , currently only index serving part is implemented

## FFI support
### dotnet nuget packages

| Runtimes                      | Nuget package                                                                                                                                 |
| ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| RuAnnoy                       | [![NuGet version](https://buildstats.info/nuget/RuAnnoy)](https://www.nuget.org/packages/RuAnnoy)                                             |
| RuAnnoy-Batteries-Windows-x64 | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Windows-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Windows-x64) |
| RuAnnoy-Batteries-Linux-x64   | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Linux-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Linux-x64)     |
| RuAnnoy-Batteries-Darwin-x64  | TODO                                                                                                                                          |

#### Installation
```xml
  <ItemGroup>
    <PackageReference Include="RuAnnoy" />
    <PackageReference Include="RuAnnoy-Batteries-Windows-x64" />
  </ItemGroup>
```
