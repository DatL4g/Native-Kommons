package dev.datlag.kommons


data object UnitedArabEmirates : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ARE")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(784)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(971)
    override val continent: Continent = Continent.Asia
}