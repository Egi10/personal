// ===================================
// GLOBAL CONFIGURATION
// ===================================
'use strict';

window.AppConfig = {
    // Loading configuration
    minLoadingTime: 1500,        // Minimum loading screen duration (ms)
    maxLoadingTime: 15000,       // Maximum time before showing error (ms)
    checkInterval: 100,          // WASM check interval (ms)
    loadingTextInterval: 2000,   // Loading text update interval (ms)

    // Debug mode
    debugMode: false,            // Enable console logging (set to true for development)

    // Loading texts
    loadingTexts: [
        'Loading',
        'Initializing',
        'Almost Ready',
        'Please Wait'
    ],

    // Error messages
    errorMessages: {
        timeout: 'The application is taking longer than expected to load.',
        script: 'Failed to load the required application files.',
        general: 'An unexpected error occurred while loading the application.'
    }
};

// Global state
window.AppState = {
    loadingStartTime: Date.now(),
    isWasmLoaded: false,
    loadTimeout: null,
    checkInterval: null,
    textInterval: null,
    currentTextIndex: 0,
    scriptLoaded: false,
    errorOccurred: false
};

// Utility: Logging
window.log = function(message, type = 'info') {
    if (window.AppConfig.debugMode) {
        console[type](`[Portfolio] ${message}`);
    }
};