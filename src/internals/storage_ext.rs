use std::mem;
use std::slice;

pub(crate) trait StorageExtensions {
    fn read_i32(&self, idx: usize) -> i32;
    fn read_f32(&self, idx: usize) -> f32;
    fn read_slice<T: Sized>(&self, idx: usize, len: usize) -> &[T];
}

#[cfg(not(target_arch = "wasm32"))]
impl StorageExtensions for memmap2::Mmap {
    fn read_i32(&self, idx: usize) -> i32 {
        // let ptr: *const i32 = unsafe { mem::transmute(&self[idx]) };
        let ptr: *const i32 = unsafe { mem::transmute(self.as_ptr().add(idx)) };
        unsafe { *ptr }
    }

    fn read_f32(&self, idx: usize) -> f32 {
        // let ptr: *const f32 = unsafe { mem::transmute(&self[idx]) };
        let ptr: *const f32 = unsafe { mem::transmute(self.as_ptr().add(idx)) };
        unsafe { *ptr }
    }

    fn read_slice<T: Sized>(&self, idx: usize, len: usize) -> &[T] {
        // let ptr: *const T = unsafe { mem::transmute(&self[idx]) };
        let ptr: *const T = unsafe { mem::transmute(self.as_ptr().add(idx)) };
        unsafe { slice::from_raw_parts(ptr, len) }
    }
}

impl StorageExtensions for Vec<u8> {
    fn read_i32(&self, idx: usize) -> i32 {
        let ptr: *const i32 = unsafe { mem::transmute(self.as_ptr().add(idx)) };
        unsafe { *ptr }
    }

    fn read_f32(&self, idx: usize) -> f32 {
        let ptr: *const f32 = unsafe { mem::transmute(self.as_ptr().add(idx)) };
        unsafe { *ptr }
    }

    fn read_slice<T: Sized>(&self, idx: usize, len: usize) -> &[T] {
        let ptr: *const T = unsafe { mem::transmute(self.as_ptr().add(idx)) };
        unsafe { slice::from_raw_parts(ptr, len) }
    }
}
