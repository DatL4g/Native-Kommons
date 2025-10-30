package dev.datlag.kommons


data object SouthGeorgiaAndTheSouthSandwichIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GS")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SGS")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(239)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(500)
}