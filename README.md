# RuAnnoy

[![main](https://github.com/kis3tar/RuAnnoy/actions/workflows/main.yml/badge.svg)](https://github.com/kis3tar/RuAnnoy/actions/workflows/main.yml)
[![travis](https://travis-ci.com/kis3tar/RuAnnoy.svg?branch=master)](https://travis-ci.com/github/kis3tar/RuAnnoy)
[![MIT License](https://img.shields.io/github/license/kis3tar/RuAnnoy.svg)](https://github.com/kis3tar/RuAnnoy/blob/master/LICENSE)
========
<!-- [![appveyor](https://ci.appveyor.com/api/projects/status/ux13ive7vhsg32el/branch/master?svg=true)](https://ci.appveyor.com/project/kis3tar/ruannoy/branch/master) -->

This library is a rust port of [spotify/annoy](https://github.com/spotify/annoy) , currently only index serving is supported.

It also provides [FFI bindings](https://github.com/kis3tar/RuAnnoy#ffi-support) for [jvm](https://github.com/kis3tar/RuAnnoy#kotlinjava), [dotnet](https://github.com/kis3tar/RuAnnoy#dotnet) and [dart](https://github.com/kis3tar/RuAnnoy#dart)

Metric | Serve | Build | jvm Binding | dotnet Binding | dart Binding
| :--- | :---: | ---: | -- | -- | -- |
Angular | ✅ | ❌ | ✅ | ✅ | ✅
Euclidean | ✅ | ❌ | ✅ | ✅ | ✅
Manhattan | ✅ | ❌ | ✅ | ✅ | ✅
Dot | ✅ | ❌ | ✅ | ✅ | ✅
Hamming | ❌ | ❌ | ❌ | ❌  | ❌

### Install via [crates.io](https://crates.io/crates/annoy-rs)
[![Crates.io](https://img.shields.io/crates/v/annoy-rs.svg)](https://crates.io/crates/annoy-rs)
[![codecov](https://codecov.io/gh/kis3tar/RuAnnoy/branch/master/graph/badge.svg?token=jVO7N0AVTH)](https://codecov.io/gh/kis3tar/RuAnnoy)
```toml
# Cargo.toml
[dependencies]
annoy-rs = "0"
```

### Usage
```rust
use annoy_rs::*;

let index = AnnoyIndex::load(10, "index.ann", IndexType::Angular).unwrap();
let v0 = index.get_item_vector(0);
let nearest = index.get_nearest(v0.as_ref(), 5, -1, true);
```

## FFI support

### kotlin/java

It uses JNI bindings to rust crate and is ~5-10x faster than [pure java implementation](https://github.com/spotify/annoy-java) in [benchmark scenario](https://github.com/kis3tar/RuAnnoy/tree/master/bench)
#### Install via [jitpack.io](https://jitpack.io/#kis3tar/RuAnnoy)
[![Release](https://jitpack.io/v/kis3tar/RuAnnoy.svg)](https://jitpack.io/#kis3tar/RuAnnoy)
```gradle
repositories {
  mavenCentral()
  maven { url 'https://jitpack.io' }
}
  
dependencies {
  implementation 'com.github.kis3tar:RuAnnoy:<tag>'
}
```
#### Usage
```kotlin
val index = AnnoyIndex.tryLoad("index.5d.ann", 5, IndexType.Angular)
```

### dotnet

| Runtimes                      | Nuget package                                                                                                                                 |
| ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| RuAnnoy                       | [![NuGet version](https://buildstats.info/nuget/RuAnnoy)](https://www.nuget.org/packages/RuAnnoy)                                             |
| RuAnnoy-Batteries-Windows-x64 | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Windows-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Windows-x64) |
| RuAnnoy-Batteries-Linux-x64   | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Linux-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Linux-x64)     |
| RuAnnoy-Batteries-Darwin-x64  | [![NuGet version](https://buildstats.info/nuget/RuAnnoy-Batteries-Darwin-x64)](https://www.nuget.org/packages/RuAnnoy-Batteries-Darwin-x64)   |

#### Install via nuget
```xml
  <ItemGroup>
    <PackageReference Include="RuAnnoy" Version="*" />
    <PackageReference Include="RuAnnoy-Batteries-Windows-x64" Version="*" />
  </ItemGroup>
```
#### Usage
```csharp
var index = AnnoyIndex.Load("index.5d.ann", 5, IndexType.Angular);
```

### dart

#### Install via [pub.dev](https://pub.dev/packages/dart_native_annoy)

```yaml
# pubspec.yaml
dependencies:
  dart_native_annoy: ^0.1.0
```
#### Usage
```dart
import 'dart:ffi';
import 'package:dart_native_annoy/annoy.dart';

/// Creat factory from DynamicLibrary
final fac = AnnoyIndexFactory(lib: DynamicLibrary.open('libannoy_rs.so'));

/// Load index
final index = indexFactory.loadIndex(
      'index.euclidean.5d.ann', 5, IndexType.Euclidean)!;

print('size: ${index.size}');

final v3 = index.getItemVector(3);

final nearest = index.getNearest(v0, 5, includeDistance: true);
```


## TODO
+ Index building support
+ CLI tool to build index from file
