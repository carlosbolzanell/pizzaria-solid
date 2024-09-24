/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      fontFamily: {
        'kanit': ['Kanit', 'sans-serif'],
        'kalam': ['Kalam', 'cursive'],
      },
      colors:{
        "primary": "#31572C",
        "secondary": "#9B2226"
      }
    },
  },
  plugins: [],
}

